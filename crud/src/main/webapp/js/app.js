'use strict';
var app = angular.module('app', ['ui.bootstrap']);

app.controller('myController', function ($scope, $http) {
    $scope.userList = [];
    $scope.createShow = false;
    $scope.curDate = new Date();

    $scope.list = function(){
        $http.get('/api/user/').success(function(data){
            if(data){
                $scope.userList = data;
                console.log(JSON.stringify(data));
                for(var i=0;i<$scope.userList.length;i++)
                    $scope.userList[i].dob = new moment($scope.userList[i].dob).format('YYYY-MM-DD');//YYYY-MM-DD hh:mm a
                $scope.TotalRecordCount = data.length;
            }
        }).error(function(err){
            $.notify(err.message,"error");
        });
    };

    $scope.create = function() {
        $scope.head = "Create";
        $scope.usersCreateForm.$setUntouched();
        $scope.details = {};
        $scope.createShow = !$scope.createShow;
    };

    $scope.edit = function(user) {
        $scope.head = "Update";
        $scope.usersCreateForm.$setUntouched();
        $scope.details = {};
        $scope.details.id = user.id;
        $scope.details.firstName = user.firstName;
        $scope.details.lastName = user.lastName;
        $scope.details.username = user.username;
        $scope.details.dob = new Date(user.dob);
        $scope.createShow = true;
    };

    $scope.deleteUser = function(user){
        $http.delete('/api/user/'+user.id).success(function(response){
            $.notify("User deleted successfully","success");
            $scope.list();
        }).error(function(err){
            $.notify(err.message,"success");
        });
    }

    $scope.save = function(){
        if($scope.details.id){
            $http.put('/api/user/'+$scope.details.id, $scope.details).success(function(response){
                if(response){
                    $.notify("User updated successfully","success");
                    $scope.createShow = false;
                    $scope.list();
                }
            }).error(function(err){
                $.notify(err.message,"success");
            });
        } else {
            $http.post('/api/user/',$scope.details).success(function(response){
                if(response){
                    $.notify("User saved successfully","success");
                    $scope.createShow = false;
                    $scope.list();
                }
            }).error(function(err){
                $.notify(err.message,"success");
            });
        }
    }
});