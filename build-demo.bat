@echo off
echo -------------------------------------------------
echo l       Third-party Push Integration Demo       l
echo -------------------------------------------------
echo Enter Available: [1]AirShip [2]Netmera [3]OneSignal [4]Wonderpush [5]Indigitall [6]Plotprojects [7]Vizury
[8]MoEngage [9]CatchMedia
echo .
set /p demoName=Please enter the number(eg: 1): 
if "%demoName%"=="1" goto AirshipDemo
if "%demoName%"=="2" goto NetmeraDemo
if "%demoName%"=="3" goto OneSignalDemo
if "%demoName%"=="4" goto WonderpushDemo
if "%demoName%"=="5" goto IndigitallDemo
if "%demoName%"=="6" goto PlotprojectsDemo
if "%demoName%"=="7" goto VizuryDemo
if "%demoName%"=="8" goto MoEngageDemo
if "%demoName%"=="9" goto CatchMediaDemo
exit

:AirshipDemo
echo -------Build Airship demo start...
call .\gradlew.bat :AirshipPushDemo:build
echo -------Build Airship demo end...
goto end

:NetmeraDemo
echo -------Build Airship demo start...
call .\gradlew.bat :NetmeraPushDemo:build
echo -------Build Airship demo end...
goto end

:OneSignalDemo
echo -------Build OneSignal demo start...
call .\gradlew.bat :OnesignalPushDemo:build
echo -------Build OneSignal demo end...
goto end

:WonderpushDemo
echo -------Build Wonderpush demo start...
call .\gradlew.bat :WonderpushPushDemo:build
echo -------Build Wonderpush demo end...
goto end

:IndigitallDemo
echo -------Build Indigitall demo start...
call .\gradlew.bat :IndigitallPushDemo:build
echo -------Build Indigitall demo end...
goto end

:PlotprojectsDemo
echo -------Build Plotprojects demo start...
call .\gradlew.bat :PlotprojectsPushDemo:build
echo -------Build Plotprojects demo end...
goto end

:VizuryDemo
echo -------Build Vizury demo start...
call .\gradlew.bat :VizuryPushDemo:build
echo -------Build Vizury demo end...
goto end

:MoEngageDemo
echo -------Build MoEngage demo start...
call .\gradlew.bat :MoEngagePushDemo:build
echo -------Build MoEngage demo end...
goto end

:MoEngageDemo
echo -------Build CatchMedia demo start...
call .\gradlew.bat :CatchMediaPushDemo:build
echo -------Build CatchMedia demo end...
goto end