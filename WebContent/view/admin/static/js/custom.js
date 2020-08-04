document.addEventListener('DOMContentLoaded', () => {
	let roles = document.querySelectorAll('[name="role"]');
	let fullRoleToggle = document.querySelector('#fullRole');

	roles && roles.forEach(item => item.addEventListener('click', setFullRoleChecked));

	fullRoleToggle && fullRoleToggle.addEventListener('click', (event) => {
		if (event.target.checked) {
			roles.forEach(item => item.checked = true);
		} else {
			roles.forEach(item => item.checked = false);
		}
	});

	function setFullRoleChecked(event) {
		for (let i = 0; i < roles.length; i++) {
			if (roles[i].checked === false) {
				console.log(false);
				fullRoleToggle.checked = false;
				return;
			}
		}

		console.log(true);
		fullRoleToggle.checked = true;
		return;
	}

	// delete product
	let deleteProductBtns = document.querySelectorAll('.btnDeleteProduct');

	for (let i = 0; i < deleteProductBtns.length; i++) {
		deleteProductBtns[i].addEventListener('click', () => {
			deleteProduct(deleteProductBtns[i].dataset.id);
		});
	}

	function deleteProduct(id) {
		if (confirm(`Xóa sản phẩm ${id}?`)) {
			axios.delete(`http://localhost:84/CatStore/admin/products/delete?id=${id}`)
				.then(res => {
					if (res.data === 'Failed') {
						alert('Delete failed');
					} else if (res.data === 'OK') {
						alert('Delete successful');
					} else {
						// do nothing
					}

					window.location.reload();
				})
				.catch(err => console.log(err));
		}
	}

	// delete orders
	let deleteOrdersBtns = document.querySelectorAll('.btnDeleteOrders');

	for (let i = 0; i < deleteOrdersBtns.length; i++) {
		deleteOrdersBtns[i].addEventListener('click', () => {
			deleteOrders(deleteOrdersBtns[i].dataset.id);
		});
	}

	function deleteOrders(id) {
		if (confirm(`Xóa đơn hàng ${id}?`)) {
			axios.delete(`http://localhost:84/CatStore/admin/orders/delete?id=${id}`)
				.then(res => {
					if (res.data === 'Failed') {
						alert('Delete failed');
					} else if (res.data === 'OK') {
						alert('Delete successful');
					} else {
						// do nothing
					}

					window.location.reload();
				})
				.catch(err => console.log(err));
		}
	}

	// delete customer
	let deleteCustomerBtns = document.querySelectorAll('.btnDeleteCustomer');

	for (let i = 0; i < deleteCustomerBtns.length; i++) {
		deleteCustomerBtns[i].addEventListener('click', () => {
			deleteCustomer(deleteCustomerBtns[i].dataset.id);
		});
	}

	function deleteCustomer(id) {
		if (confirm(`Xóa khách hàng ${id}?`)) {
			axios.delete(`http://localhost:84/CatStore/admin/customers/delete?id=${id}`)
				.then(res => {
					if (res.data === 'Failed') {
						alert('Delete failed');
					} else if (res.data === 'OK') {
						alert('Delete successful');
					} else {
						// do nothing
					}

					window.location.reload();
				})
				.catch(err => console.log(err));
		}
	}
	
	let deleteOrdersDetailBtn = document.getElementsByClassName('deleteOrdersDetailBtn');
	let ordersItem = document.getElementsByClassName("item");
	
	for (let i = 0; i < deleteOrdersDetailBtn.length; i++) {
		deleteOrdersDetailBtn[i].addEventListener('click', function() {
			this.closest('.item').remove()
		});
	}

	let btnCreateProduct = document.querySelector('.btnCreateProduct');
	btnCreateProduct && btnCreateProduct.addEventListener('click', () => {
		let productList = document.querySelector('#product-list');

		productList.innerHTML += `
			<tr class="item">
				<td>
					<input
						type="text"
						class="form-control"
						required
						name="productId"
					/>
				</td>
				<td>
					<input
						type="number"
						class="form-control"
						required
						min="1"
						name="amount"
					/>
				</td>
				<td>
					<button type="button" class="btn btn-danger btn-circle deleteOrdersDetailBtn">
						<i class="fas fa-trash"></i>
					</button>
				</td>
			</tr>
		`;

		deleteOrdersDetailBtn = document.getElementsByClassName('deleteOrdersDetailBtn');		
		for (let i = 0; i < deleteOrdersDetailBtn.length; i++) {
			deleteOrdersDetailBtn[i].addEventListener('click', function() {
				this.closest('.item').remove()
			});
		}
	});
});