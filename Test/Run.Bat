set path=%path%;C:\Program Files (x86)\Java\jre1.8.0_92\bin
cd C:\Selenium\workspace\PC
mvn test -DsuiteFile="TestNG.xml"
timeout 20
