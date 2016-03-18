<div class="col-sm-9">
					  <div class="form-group">
                        <label>Your gender</label>
                        <span class="help"></span>
						<div>
						<input type="radio" value="male" name="optionyes" id="male" <?php if($rows['gender']=="male"){ echo "checked=\"yes\""; }?>">
                            <label for="male">Male</label>
                            <input type="radio" value="female" name="optionyes" id="female" <?php if($rows['gender']=="female"){  echo "checked=\"yes\""; }?>">
                            <label for="female">Female</label>
                           </div> 
                          </div>
                        </div>