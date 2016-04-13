<!-- Include bootbox.js -->
<script src="//oss.maxcdn.com/bootbox/4.2.0/bootbox.min.js"></script>

<button class="btn btn-default" id="loginButton">Login</button>

<!-- The login modal. Don't display it initially -->
<form id="loginForm" method="post" class="form-horizontal" style="display: none;">
    <div class="form-group">
        <label class="col-xs-3 control-label">Username</label>
        <div class="col-xs-5">
            <input type="text" class="form-control" name="username" />
        </div>
    </div>

    <div class="form-group">
        <label class="col-xs-3 control-label">Password</label>
        <div class="col-xs-5">
            <input type="password" class="form-control" name="password" />
        </div>
    </div>

    <div class="form-group">
        <div class="col-xs-5 col-xs-offset-3">
            <button type="submit" class="btn btn-default">Login</button>
        </div>
    </div>
</form>

<script>
$(document).ready(function() {
    $('#loginForm').formValidation({
        framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            username: {
                validators: {
                    notEmpty: {
                        message: 'The username is required'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: 'The password is required'
                    }
                }
            }
        }
    });

    // Login button click handler
    $('#loginButton').on('click', function() {
        bootbox
            .dialog({
                title: 'Login',
                message: $('#loginForm'),
                show: false // We will show it manually later
            })
            .on('shown.bs.modal', function() {
                $('#loginForm')
                    .show()                             // Show the login form
                    .formValidation('resetForm', true); // Reset form
            })
            .on('hide.bs.modal', function(e) {
                // Bootbox will remove the modal (including the body which contains the login form)
                // after hiding the modal
                // Therefor, we need to backup the form
                $('#loginForm').hide().appendTo('body');
            })
            .modal('show');
    });
});
bootbox.alert("Hello world!");
</script>

