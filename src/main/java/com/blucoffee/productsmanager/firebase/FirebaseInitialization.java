package com.blucoffee.productsmanager.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Service
public class FirebaseInitialization {

    @PostConstruct
    public void initialization(){
        try {
            String serviceAccountKey = System.getenv("FIREBASE_SERVICE_ACCOUNT_KEY");
            if (serviceAccountKey == null || serviceAccountKey.isEmpty()) {
                throw new RuntimeException("Firebase service account key is not set in environment variables");
            }

            InputStream serviceAccount = new ByteArrayInputStream(serviceAccountKey.getBytes());

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
