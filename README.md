Das ist mein Projekt.

Ich möchte ein Rezeptbuch für meine eigenen Rezepte bauen, um sie an einem Ort speichern zu können.

Entwickelt wird auf IntelliJ als IDE, mit Google Chrome zum Debuggen der Weboberfläche.

Im Backend verwendet:
-Deploy des Maven Projekts auf einem Wildfly 19
-Hibernate
-Resteasy
-Für die Datenbank eine MySQL DB von XAMPP
-> Dump im Projekt hinterlegt, resources, rezeptbuch.sql
Passwort und Benutzername müssen in der persistence.xml für Hibernate angepasst werden. Stehen standardmäßig auf root/root



Die Web-App ist mit Angular gemacht. Entsprechend läuft es mit der Angular CLI, auf dem mitgelieferten Server.

TODO: 
- Post für REST-Api (löschen, bearbeiten, hinzufügen)
- Datenmodell erweitern
- Weboberfläche verschönern, die einzelnen Funktionen auch dort einbauen
- Suchfunktion für Rezepte (vielleicht Elasticsearch)