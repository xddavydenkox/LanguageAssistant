'use strict';

angular.module('plsApp').controller('HelloCtrl', ['$scope', 'Hello','ShowRandomWords', 'ShowWordsByCategory', 'GetDBSize',
    function($scope, Hello, ShowRandomWords, ShowWordsByCategory, GetDBSize) {

        Hello.get().$promise.then(function(data) {
             $scope.hello = data;
        });

        $scope.getRandomWords = function(inputQuantity) {
            ShowRandomWords.get({quantity: inputQuantity}).$promise.then(function(data) {
                if(inputQuantity <= $scope.dataBaseSize) {
                    $scope.listOfRandomWords = data;
                }
                else {
                    alert("Please enter another quantity which is smaller...");
                };

            });
        };

        $scope.sortField = 'id';
        $scope.reverse = true;

            GetDBSize.get().$promise.then(function(data) {
                $scope.dataBaseSize = data.size;
        });

            $scope.picture = 'rekl.jpg';
            function timeout() {
                setTimeout(function() {
                    $scope.picture = 'backInMyDay.PNG';
                    timeout();
                    $scope.$apply();
                }, 1000);
            };

        ShowWordsByCategory.get().$promise.then(function(data) {
            setTimeout(function() {
                $scope.categoryWords = data;
                timeout()
                $scope.$apply();

            },5000);
        });
    }

]);

angular.module('plsApp').controller('TestWordsCtrl', ['$scope', 'GetAllCategories', 'ShowWordsByCategory', 'GetAllUniqueTopics','GetAllWordsByTopic',
    function($scope, GetAllCategories, ShowWordsByCategory, GetAllUniqueTopics, GetAllWordsByTopic) {

            var decriment = 0;

            GetAllCategories.get().$promise.then(function(data) {
                $scope.categories = data;
            });

            $scope.getTopicList = function (categoryName) {
                ShowWordsByCategory.get({category: categoryName}).$promise.then(function(data) {
                    $scope.allWordsByCategory = data;
                    $scope.notVisible = false;
                    $scope.buttonIsHidden = true;
                    decriment=0;
                });
            };

            ShowWordsByCategory.get().$promise.then(function(data) {
                $scope.allWordsByCategory = data;
                $scope.testSectionNonVisible = true;
                $scope.buttonIsHidden = true;


            });

            $scope.getUniqueTopicList = function(categoryName) {
                GetAllUniqueTopics.get({category: categoryName}).$promise.then(function(data) {
                    $scope.uniqueTopics = data;
                    $scope.currentCategory = ' for "' + categoryName + '" category';
                    $scope.currentTopic = '';
                    $scope.testSectionNonVisible = true;

                });
            };

            $scope.getWordsByTopic = function(topic) {
                GetAllWordsByTopic.get({topic:topic}).$promise.then(function(data) {
                    $scope.allWordsByTopic = data;
                    $scope.currentTopic = ' and "' + topic + '" topic';
                    $scope.allWordsByCategory = data;
                    $scope.buttonIsHidden = false;
                    $scope.buttonName = 'Next';
                    $scope.isDisabled = false;
                    $scope.wrongTranslationList=[];
                });
            };

         // -> Fisher–Yates shuffle algorithm
              $scope.shuffleArray = function(array) {
              $scope.notVisible = true;
              $scope.testSectionNonVisible = false;
              var m = array.length, t, i;
            
              // While there remain elements to shuffle
              while (m) {
                // Pick a remaining element…
                i = Math.floor(Math.random() * m--);
            
                // And swap it with the current element.
                t = array[m];
                array[m] = array[i];
                array[i] = t;
              }
            
              return array;
            };

            $scope.getWordsOneByOne = function(array) {
                var engWord = $scope.engWord;
                
                if (decriment < array.length) {
                    decriment ++;
                    console.log(array[decriment-1]);
                    $scope.rusWord = array[decriment-1].rusword;
                    $scope.engWord = array[decriment-1].engword;
                    $scope.actualEngWord = '';
                }
                else {
                    $scope.buttonName = 'Finish';
                    $scope.isDisabled = true;
                    alert("Congratulations. You've finished yout test. Check your mistakes and try again!");
                }
            };

            $scope.wrongTranslationList = [];

            $scope.compareTranslation = function() {
                var actualE = $scope.actualEngWord;
                if ($scope.engWord === actualE) {
                    console.log("Your translation is correct!"+actualE+"="+$scope.rusWord);

                }
                else {
                    console.log("WRONG!!!"+actualE+"!="+$scope.rusWord );
                    var eng = $scope.engWord;
                    var rus = $scope.rusWord;
                    var array = {engword:eng, rusword:rus};
                    $scope.wrongTranslationList.push(array);
                }
            };
            
            $scope.removeError = function(word) {
                var i = $scope.wrongTranslationList.indexOf(word);
                $scope.wrongTranslationList.splice(i,1);
            }

     }
 ]);