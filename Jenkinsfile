pipeline {
    agent { label 'master' }

    stages {
        stage('Docker version') {
            steps {
                sh "echo $USER"
                sh 'docker version'
            }
        }
        stage('Delete workspace before build starts') {
            steps {
                echo 'Deleting workspace'
                deleteDir()
            }
        }
        stage('Checkout') {
            steps{
                git branch: 'master',
                    url: 'https://github.com/DanilaZaytsev/springhello.git'
                }
        }
        stage('Test') {
            steps{
                dir('.') {
                    sh "ls -la "
                    sh "pwd"
                }
            }
        }

        stage('Build docker image') {
            steps{
                dir('.') {
                    sh 'docker build -t dz/spring:0.2 .'
                }
            }
        }
    }
}