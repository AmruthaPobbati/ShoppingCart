var cartApp = angular.module("cartApp",[]);

cartApp.controller("cartCtrl", function($scope, $http){
	
	$scope.refreshCart = function(){
		$http.get('/ShoppingCart/rest/cart/' + $scope.cartId).success(function(data){
			$scope.cart = data;
		});
	};
	
	$scope.clearCart = function(){
		$http.delete('/ShoppingCart/rest/cart/'+ $scope.cartId).success($scope.refreshCart());
	};
	
	$scope.initCartId = function(cartId){
		$scope.cartId = cartId;
		$scope.refreshCart();
	};
	
	$scope.addToCart = function(id){
		$http.put('/ShoppingCart/rest/cart/add/'+ id).success(function(){
			alert("Product successfully added to cart");
		});
	};
	
	$scope.removeFromCart = function(id){
		$http.put('/ShoppingCart/rest/cart/remove/'+ id).success(function(data){
			$scope.refreshCart();
		});
	};
	
	$scope.calGrandTotal = function(){
		var grandTotal = 0;
		
		for(var i=0; i < $scope.cart.cartItems.length ; i++){
			grandTotal = grandTotal + $scope.cart.cartItems[i].totalPrice;
		}
		
		return grandTotal;
	}
});