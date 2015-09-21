'use strict';

/*languageApp.factory('SayHello', function($resource) {
	return $resource('http://localhost:8080/my-app/engwords/sayHello');
});
*/
/*
angular.module('languageApp')
.factory('EngWordsInfo', function($resource) {
	return $resource('http://localhost:8080/my-app/wordsinfo/byEngWord/:word', {word: '@word'});
});*/




/*var sayHelloService = angular.module('sayHelloService', ['ngResource']);

sayHelloService.factory('Hello', ['$resource',
            function($resource){
//				return $resource('http://localhost:8080/my-app/engwords/sayHello', {}, {
//					query: {method:'GET', isArray:false}
//				});
				return 'Hello';
			}]);
*/


angular.module('plsApp').factory('Hello', ['$resource',
   function($resource) {
        return $resource('http://localhost:8080/my-app/engwords/sayHello', null, {
            'get': {method: 'GET', isArray: false}
        });
    }
]);

angular.module('plsApp').factory('ShowRandomWords', ['$resource',
    function($resource) {
        return $resource('http://localhost:8080/my-app/engwords/wordsinfo/random/:quantity', null, {
                'get': {method:'GET', isArray:true}
        });
    }
]);

angular.module('plsApp').factory('GetDBSize', ['$resource',
function($resource) {
    return $resource('http://localhost:8080/my-app/engwords/dataBaseSize', null, {
            'get': {method:'GET', isArray:false}
        });
    }
]);
angular.module('plsApp').factory('ShowWordsByCategory', ['$resource',
     function($resource) {
         return $resource('http://localhost:8080/my-app/engwords/wordsinfo/bycategory/:category', {category: 'Numbers'}, {
                 'get': {method:'GET', isArray:true}
         });
     }
 ]);

angular.module('plsApp').factory('GetAllCategories', ['$resource',
     function($resource) {
         return $resource('http://localhost:8080/my-app/engwords/wordsinfo/getCategoryList', null, {
                 'get': {method:'GET', isArray:true}
         });
     }
 ]);

angular.module('plsApp').factory('GetAllUniqueTopics', ['$resource',
    function($resource) {
        return $resource('http://localhost:8080/my-app/engwords/wordsinfo/getTopicList/:category', {category:'Color'}, {
                'get': {method:'GET', isArray:true}
        });
    }
]);

angular.module('plsApp').factory('GetAllWordsByTopic', ['$resource',
    function($resource) {
        return $resource('http://localhost:8080/my-app/engwords/wordsinfo/bytopic/:topic', null, {
                'get': {method:'GET', isArray:true}
        });
    }
]);

