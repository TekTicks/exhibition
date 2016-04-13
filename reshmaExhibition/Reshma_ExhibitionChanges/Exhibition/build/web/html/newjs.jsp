<%-- 
    Document   : newjs
    Created on : Mar 28, 2016, 6:31:32 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
                                                    
        <script> 
                $(document).ready(function(){
                $('ul.tabs').each(function(){
                    var $active, $content, $links = $(this).find('a');
                    $active = $links.first().addClass('active');
                    $content = $($active.attr('href'));
                    $links.not(':first').each(function () {
                    $($(this).attr('href')).hide();
                    });

                    $(this).on('click', 'a', function(e){
                        $active.removeClass('active');
                        $content.hide();
                        $active = $(this);
                        $content = $($(this).attr('href'));
                        $active.addClass('active');
                        $content.show();
                        e.preventDefault();
                    });
                });
            });


            </script>
    </head>
    <body>
       <ul class='tabs'>
            <li><a href='#tab1'>Tab 1</a></li>
            <li><a href='#tab2'>Tab 2</a></li>
        </ul>
<div id='tab1'>
            <h3>Section 1</h3>
            <p>Lorem ipsum dolor sit amet, consssectetur adipiscing elit. Donec lobortis placerat dolor id aliquet. Sed a orci in justo blandit commodo. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae.</p>
                <form id="form1" action="" method="post">            
      <input id="button-1" name="" type="submit" />
</form>
        </div>
<div id='tab2'>
<a name="tab2"></a>
            <h3>Section 2</h3>
            <p>Aenean et est tortor. In pharetra pretium convallis. Mauris sollicitudin ligula non mi hendrerit varius. Fusce convallis hendrerit mauris, eu accumsan nisl aliquam eu.</p>
            
    <form id="form2" action="" method="post">            
      <input id="button-2" name="" type="submit" />
</form>
        </div>
<div>
  <h2>RESULTS </h2>
</div>        

    </body>
</html>
