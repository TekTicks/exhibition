
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
<body>
<form method="post" action="UploadFile" enctype="multipart/form-data">
<input type="file" id="files" />
<img id="image"  style="width:200px;height:200px"/>
<script>
document.getElementById("files").onchange = function () {
    var reader = new FileReader();

    reader.onload = function (e) {
        // get loaded data and render thumbnail.
        document.getElementById("image").src = e.target.result;
    };

    // read the image file as a data URL.
    reader.readAsDataURL(this.files[0]);
  
   
};

</script>

</form> <jsp:include page="insertimage.jsp" />
   
</body>
</html>
 