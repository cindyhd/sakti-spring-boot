package com.example.session.service;

import com.example.session.entity.AccessMatrix;
import com.example.session.entity.SessionLogin;
import com.example.session.repository.AccessMatrixRepository;
import com.example.session.repository.AclRepository;
import com.example.session.repository.SessionLoginRepository;
import edu.vt.middleware.crypt.digest.SHA512;
import edu.vt.middleware.crypt.util.Convert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

@Service
public class SessionLoginService {
    @Autowired
    private SessionLoginRepository sessionLoginRepository;

    @Autowired
    private AclRepository aclRepository;

    @Autowired
    private AccessMatrixRepository accessMatrixRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(SessionLoginService.class);

    public SessionLogin isSessionLoginValid(String sessionId, String token, String timestamp) {
        byte[] decodeSaktiTokenId = Base64.getDecoder().decode(token);
        String plainSaktiTokenId = new String(decodeSaktiTokenId);
        String[] tokens = plainSaktiTokenId.split("\\|");

        SessionLogin sessionLogin = this.getSessionLoginByUserId(tokens[0]);
        if (sessionLogin != null) {
            String _key = String.format("%s:%s:%s", tokens[0], sessionLogin.getCURRENT_ALPHA_ID(), tokens[1]);
            String expectedSessionId = Convert.toHex(new SHA512().digest(_key.getBytes(StandardCharsets.UTF_8)));
            if (expectedSessionId.equals(sessionId) && timestamp.equals(tokens[2])) {
                return sessionLogin;
            }
        }
        return null;
    }

    public boolean isAccessValid(String userId, String url) {
        List<AccessMatrix> accessMatrixList =  accessMatrixRepository.findByUrlRest(url);
        if (!CollectionUtils.isEmpty(accessMatrixList)) {
            boolean result = false;
            for (AccessMatrix wrapper : accessMatrixList) {
                int counter = 0;
                Integer form = wrapper.getFormId();
                switch (wrapper.getAclValue()) {
                    case 1:
                        counter = aclRepository.countFormAclCreateByUserAndFormId(userId, form);
                        break;
                    case 2:
                        counter = aclRepository.countFormAclReadByUserAndFormId(userId, form);
                        break;
                    case 3:
                        counter = aclRepository.countFormAclUpdateByUserAndFormId(userId, form);
                        break;
                    case 4:
                        counter = aclRepository.countFormAclDeleteByUserAndFormId(userId, form);
                        break;
                    default:
                        LOGGER.error("Invalid acl value");
                }
                if (counter > 0) {
                    result = true;
                }
            }
            return result;
        }
        return true;
    }

    public SessionLogin getSessionLoginByUserId(String userId) {
        SessionLogin sessionLogin = sessionLoginRepository.findByUSERID(userId);
        return sessionLogin;
    }
}
