
@echo off

:: Path to Service Discovery
SET "DIR1=D:/Trello Task Manager DevOps and Infra Project/servicediscovery"
:: path to central config
SET "DIR2=D:/Trello Task Manager DevOps and Infra Project/centralconfig"
:: path to api gateway
SET "DIR3=D:/Trello Task Manager DevOps and Infra Project/apigateway"
:: path to identity service
SET "DIR4=D:/Trello Task Manager DevOps and Infra Project/identityservice"
:: path to project service
SET "DIR5=D:/Trello Task Manager DevOps and Infra Project/projectservice"

:: launch windows terminal, opening above tabs , navigate to directories, and run spring boot applications

:: 1. Launch Service Discovery (Creates Window 1)
wt -w 1 new-tab -d "%DIR1%" -p "Windows PowerShell" powershell -NoExit -Command "mvn spring-boot:run"
timeout /t 10 /nobreak

:: 2. Launch Central Config (Injects into Window 1)
wt -w 1 new-tab -d "%DIR2%" -p "Windows PowerShell" powershell -NoExit -Command "mvn spring-boot:run"
timeout /t 10 /nobreak

:: 3. Launch API Gateway
wt -w 1 new-tab -d "%DIR3%" -p "Windows PowerShell" powershell -NoExit -Command "mvn spring-boot:run"
timeout /t 5 /nobreak

:: 4. Launch Identity Service
wt -w 1 -d "%DIR4%" -p "Windows PowerShell" powershell -NoExit -Command "mvn spring-boot:run"
timeout /t 5 /nobreak

:: 5. Launch Project Service
wt -w 1 new-tab -d "%DIR5%" -p "Windows PowerShell" powershell -NoExit -Command "mvn spring-boot:run"
