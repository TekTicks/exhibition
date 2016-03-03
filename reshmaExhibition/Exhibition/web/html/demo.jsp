
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
var string = document.readyState;
switch (document.readyState) {
  case "loading":
    // The document is still loading.
    break;
  case "interactive":
    // The document has finished loading. We can now access the DOM elements.
    var span = document.createElement("span");
    span.textContent = "A <span> element.";
    document.body.appendChild(span);
    break;
  case "complete":
    // The page is fully loaded.
    console.log("The first CSS rule is: " + document.styleSheets[0].cssRules[0].cssText);
    break;
}
</script>

</form>
    
    
 

 
 

  
</body>


 
</html>
 