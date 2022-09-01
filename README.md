**Task comments**  
Project structure:  
- authserver module: includes implementation of cusmon authorithation server with JWT.  
- core module: includes dao and service layer.  
- api module: controller layer, it includes implementation of resource server with Spring Security.  
- examples of some SQL scripts you can find [here](https://github.com/MariiaKushel/organization-structure/blob/dev/core/src/main/resources/SQLSriptsExample)  

**Nuances**  
- All entity can not be removed at all from database. Instead of this I add marker "active" as analog removed entity. 
Now functional to make active again deactivated entity not present, but it can be implements in the future.  
- Hierarchical structure of Department represent like included Subdepertments. 
As well, It was added default Department with default Subdepartment for Director of Directorate.  
- Entity employee (any position) was separated from entity User (User represents user of system).
It was done to can have Admin user of system with additional possibility.  
- Operations by create, update and deactivate Employee needs more checks to exclude controversial situations. It can be implements in the future.  

![Alt-текст]()
