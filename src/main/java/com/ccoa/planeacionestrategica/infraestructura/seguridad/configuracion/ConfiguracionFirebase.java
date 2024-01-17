package com.ccoa.planeacionestrategica.infraestructura.seguridad.configuracion;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class ConfiguracionFirebase {

    @Bean
    public FirebaseApp firebaseApp() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("/home/administrador/Conciliaciones/firebase/pat-ccoa-firebase-adminsdk-yk30n-7125cba998.json");
                //C:/Users/j.cardona/PACCOA/PACCOAB/CCOA/src/main/resources/
                ///home/administrador/Conciliaciones/firebase/
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        return FirebaseApp.initializeApp(options);

    }
}
