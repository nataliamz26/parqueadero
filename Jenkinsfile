pipeline{
	
		agent {
		label 'Slave_Induccion'
		}
	
        
		triggers {
        pollSCM('@hourly')
		}
	
		tools {
		jdk 'JDK8_Centos' 
		gradle 'Gradle5.0_Centos' 
		}
	
		options {
			buildDiscarder(logRotator(numToKeepStr: '3'))
			disableConcurrentBuilds()
		}
		
		environment {
        PROJECT_PATH_BACK = 'parqueadero'
		}
		parameters{
			booleanParam defaultValue: false, description: 'Push a registry AWS', name: 'pushdeploy'
		}
		
		stages{
		
			stage('Checkout') {
				steps {
                echo '------------>Checkout desde Git Microservicio<------------'
                checkout([$class: 'GitSCM', 
                branches: [[name: 'master']], 
                doGenerateSubmoduleConfigurations: false, 
                extensions: [[$class: 'RelativeTargetDirectory', 
                relativeTargetDir: 'parqueadero']], 
                gitTool: 'Git_Centos', 
                submoduleCfg: [], 
                userRemoteConfigs: [[credentialsId: 'GitHub_nataliamz26', 
                url: 'https://github.com/nataliamz26/parqueadero.git']]])
				}
			}
		
	
		
			stage('Compile'){
				parallel {
					stage('Compile backend'){
						steps{
							echo "------------>Compilaci�n backend<------------"
							dir("${PROJECT_PATH_BACK}"){
								sh 'gradle build -x test'
							}
						}
					
					}
				}
			}
			stage('Unit Test - Cobertura'){
				parallel {
					stage('Test - Cobertura backend'){
						steps {
							echo '------------>test backend<------------'
							dir("${PROJECT_PATH_BACK}"){
								sh 'gradle --stacktrace test'
								
							}
						}
					}
				}
			}
			
			stage('Sonar Analysis'){
				steps{
					echo '------------>Analisis de c�digo est�tico<------------'
					  withSonarQubeEnv('Sonar') {
                     sh "${tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=./sonar-project.properties"
                     }
				}
			}
		
		

		}
		post {
			failure {
				mail(to: 'natalia.munoz@ceiba.com.co',
				body:"Build failed in Jenkins: Project: ${env.JOB_NAME} Build /n Number: ${env.BUILD_NUMBER} URL de build: ${env.BUILD_NUMBER}/n/nPlease go to ${env.BUILD_URL} and verify the build",
				subject: "ERROR CI: ${env.JOB_NAME}")
			}
		}	
			
}