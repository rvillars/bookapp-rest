angular-translate with Spring bundles
=====================================
Spring Bundle based translations (i18n) for AngularJS applications with angular-translate based on the bookapp-rest code.

Technologies used:
* maven
* JPA/EclipseLink
* Spring
* ModelMapper (for DTO creation)
* JSF2
* SpringMVC
* AngularJS
* jQueryUI
* angular-translate

See also Gist: https://gist.github.com/rvillars/6422287

Keep in mind that you have to adapt the call '$translateProvider.useUrlLoader('/rest/messageBundle');' in application.js if you use another web application context than /
