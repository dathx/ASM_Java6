const app = angular.module("shopping-cart-app", []);
app.controller("cart-ctrl", function($scope, $http) {

    $scope.cart = {
        items: [],
        // add new product
        add(id) {
            var item = this.items.find(item => item.id == id);
            if (item) { //neu co sp r thi tang sl them 1
                item.qty++;
                this.saveToLocalStorage();
            } else {
                //Chua co thi tai sp tren sẻver thông qua API
                $http.get(`/rest/products/${id}`).then(resp => {
                    resp.data.qty = 1;
                    //luu vao danh sach cac hang da chon
                    this.items.push(resp.data);
                    this.saveToLocalStorage();
                })
            }
        },

        //delete product
        remove(id) {
            //tim vitri
            var index = this.items.findIndex(item => item.id == id);
            //xoa phan tu
            this.items.splice(index, 1);
            this.saveToLocalStorage();
        },

        //delete all product of cart
        clear() {
            this.items = [];
            this.saveToLocalStorage();
        },
        // Tong so luong trong cart
        get count() {
            return this.items
                .map(item => item.qty)
                .reduce((total, qty) => total + qty, 0);
        },
        //Tong thanh tien
        get amount() {
            return this.items
                .map(item => item.qty * item.price)
                .reduce((total, qty) => total + qty, 0);
        },
        saveToLocalStorage() {
            // doi items sang json
            var json = JSON.stringify(angular.copy(this.items));
            //lua vao localStorage
            localStorage.setItem("cart", json);
        },

        //doc product tu local storage
        loadFromLocalStorage() {
            //doc localSt
            var json = localStorage.getItem("cart");
            //neu co chuyen sang json add vo items, nêu ko có add mang trong
            this.items = json ? JSON.parse(json) : [];
        }

    }
    $scope.cart.loadFromLocalStorage();

    $scope.order = {
        createDate: new Date(),
        address: "",
        account: { username: $("#username").text() },
        get orderDetail() {
            return $scope.cart.items.map(item => {
                return {
                    product: { id: item.id },
                    price: item.price,
                    quantity: item.qty
                }
            });
        },
        purchase() {
            var order = angular.copy(this);
            //dat hang
            $http.post("/rest/orders", order).then(resp => {
                alert("Đặt hàng thành công")
                $scope.cart.clear;
                // chuyển sang trang chi tiết đơn hàng
                location.href = "/order/detail/" + resp.data.id;
            }).catch(error => {
                alert("Đã xảy ra lôi!!")
                console.log(error)
            })

        }
    }

});