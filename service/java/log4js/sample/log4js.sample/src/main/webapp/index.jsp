<html>
<head>
    <title>demo for log4js</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/log4js.js"></script>
    <style type="text/css">
        body {
            font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
            font-size: 14px;
            line-height: 20px;
            color: #333333;
        }
    </style>
</head>
<body>
<h2>Hello World!</h2>

<script type="text/javascript">
    window.basicInfo = {
        logUrl:"log4js",
        logLevel:"All"
    };

    function error () {
        throw "app error";
    }

    $(function(){
        $.info("ha ha");
        error();
    });
</script>
</body>
</html>
