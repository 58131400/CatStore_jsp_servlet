let productMoreInfo = document.getElementById("productMoreInfo");
const category = document.querySelector("#category");
category.addEventListener("change", (event) => {
	switch (event.target.value) {
		case "CA":
			productMoreInfo.innerHTML = `
				<div id="forCat">
					<div class="form-group">
						<label class="d-block">Sex</label>
						<div class="form-control border-0">
							<div class="custom-control custom-radio custom-control-inline">
								<input type="radio" class="custom-control-input" id="male" name="sex" value="true" required>
								<label class="custom-control-label" for="male">Male</label>
							</div>
							<div class="custom-control custom-radio custom-control-inline">
								<input type="radio" class="custom-control-input" id="female" name="sex" value="false" required>
								<label class="custom-control-label" for="female">Female</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label>Age</label>
						<input
							type="number"
							class="form-control"
							placeholder="Enter age"
							min="1"
							name="age"
							required
						>
					</div>
					<div class="form-group">
						<label>Color</label>
						<input
							type="text"
							class="form-control"
							placeholder="Enter color"
							name="color"
							required
						/>
					</div>
				</div>
			`;
			
			break;
		case "FD":
			productMoreInfo.innerHTML = `
				<div id="forFood">
					<div class="form-group">
						<label>DOM</label>
						<input type="date" id="dom" name="dom" class="form-control" required>
					</div>
					<div class="form-group">
						<label>EXP</label>
						<input type="date" id="exp" name="exp" class="form-control" required>
					</div>
					<div class="form-group">
						<label>Weight</label>
						<input
							type="number"
							class="form-control"
							placeholder="Enter weight"
							min="1"
							name="weight"
							required
						/>
					</div>
				</div>
			`;
			break;
		case "CL":
			productMoreInfo.innerHTML = `
				<div id="forClothes">
					<div class="form-group">
						<label>Color</label>
						<input type="text" name="color" class="form-control" placeholder="Enter color" required>
					</div>
					<div class="form-group">
						<label>Size</label>
						<input type="text" name="size" class="form-control" maxlength="1" placeholder="Enter size" required>
					</div>
					<div class="form-group">
						<label>Material</label>
						<input type="text" name="material" class="form-control" placeholder="Enter material" required>
					</div>
				</div>
			`;
			break;
	}
});

const dom = document.querySelector('#dom');
const exp = document.querySelector('#exp');

dom && dom.addEventListener('change', () => {
	exp.min = dom.value;
});

exp && exp.addEventListener('change', () => {
	dom.max = exp.value;
});