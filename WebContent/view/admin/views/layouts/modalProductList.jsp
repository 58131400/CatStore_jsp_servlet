<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Modal -->
<div class="modal fade" id="productListModal" tabindex="-1" role="dialog" aria-labelledby="productListModal"
	aria-hidden="true">
	<div class="modal-dialog custom-modal-dialog" role="document">
		<div class="modal-content custom-modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Please select products</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="table-responsive table-responsive-vertical">
					<table class="table table-bordered" id="modalProductList">
						<thead>
							<tr>
								<th>ProductId</th>
								<th>Name</th>
								<th>Price</th>
								<th>Select</th>
								<th>Amount</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>PRD001</td>
								<td>Sản phẩm 1</td>
								<td>20.000đ</td>
								<td>
									<input type="checkbox" />
								</td>
								<td>
									<input type="number" min="1" class="amount" />
								</td>
							</tr>
							<tr>
								<td>PRD001</td>
								<td>Sản phẩm 1</td>
								<td>20.000đ</td>
								<td>
									<input type="checkbox" />
								</td>
								<td>
									<input type="number" min="1" class="amount" />
								</td>
							</tr>
							<tr>
								<td>PRD001</td>
								<td>Sản phẩm 1</td>
								<td>20.000đ</td>
								<td>
									<input type="checkbox" />
								</td>
								<td>
									<input type="number" min="1" class="amount" />
								</td>
							</tr>
							<tr>
								<td>PRD001</td>
								<td>Sản phẩm 1</td>
								<td>20.000đ</td>
								<td>
									<input type="checkbox" />
								</td>
								<td>
									<input type="number" min="1" class="amount" />
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
				<button type="button" class="btn btn-primary">Add selected product(s) to order</button>
			</div>
		</div>
	</div>
</div>