 FROM openjdk:11
 WORKDIR /app
 ADD target/altında oluşan jar dosyası.aynı dosya host bilgisyaradan container içine taşır
 ENTYPOINT ["java", "-jar", "jar dosyası " ]

