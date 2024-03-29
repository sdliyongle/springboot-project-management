<html lang="en">

<head>
    <title>Todost ✍️</title>
    <meta name="viewport" content="height=device-height, initial-scale=1, user-scalable=no">
    <meta charset="UTF-8">
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/animate.css/3.4.0/animate.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet">
    <style>
        .body {
            /* background: #020631; */
            background: #ffffff;
            font: 14px 'Nunito', sans-serif;
        }

        ul li {
            list-style-type: none;
        }

        .today {
            font-size: 22px;
        }

        .animated.bounceIn,
        .animated.bounceOut,
        .animated.flipOutX,
        .animated.flipOutY {
            font-size: 13px;
        }

        .container {
            padding-top: 10px;
        }

        .todo-list {
            margin: 20px 0;
            padding-left: 0;
        }

        .todo-list li {
            background: #fff;
            border-radius: 5px;
            margin-bottom: 7px;
            position: relative;
            word-break: break-word;
            box-shadow: #666 0 0 0.2rem;
        }

        .todo-list li.danger {
            background: rgb(85, 41, 220);
        }

        .todo-list li.danger label {
            text-decoration: line-through;
            color: #fff;
        }

        .todo-list li.danger label .checkbox-mask {
            border-color: transparent;
        }

        .todo-list li.danger label .checkbox-mask:after {
            content: '\f00c';
            font-family: 'FontAwesome';
            display: block;
            position: absolute;
            top: -3px;
            left: 0;
        }

        .todo-list li .checkbox {
            margin: 0;
            padding: 10px 15px;
            border-radius: 5px;
        }

        .todo-list li label {
            display: block;
            padding-right: 10px;
        }

        .todo-list li label input[type="checkbox"] {
            visibility: hidden;
        }

        .todo-list li label .checkbox-mask {
            display: block;
            border: 2px solid #666;
            width: 12px;
            height: 12px;
            border-radius: 2.5px;
            position: absolute;
            margin-left: -20px;
            margin-top: 4px;
        }

        .todo-list li .close {
            display: none;
            position: absolute;
            width: 12px;
            height: 16px;
            top: 50%;
            margin-top: -8px;
            right: 10px;
            font-size: 16px;
        }

        .todo-list li .close .fa {
            line-height: 16px;
        }

        .todo-list li:hover .close {
            display: block;
        }

        .has-feedback .fa {
            line-height: 35px;
            cursor: pointer;
            pointer-events: auto;
            z-index: 10;
            display: block;
            color: #666;
            -webkit-transition: color 0.15s linear;
            transition: color 0.15s linear;
        }

        .has-feedback .fa:hover {
            color: #999;
        }

        .add-control {
            margin-top: 20px;
            position: relative;
            box-shadow: #666 0 0 0.2rem;
        }

        .add-control .form-control {
            padding-right: 25px;
        }

        .add-control .refresh {
            position: absolute;
            top: 8px;
            right: 0;
            font-size: 14px;
            -webkit-transform: translateX(100%);
            transform: translateX(100%);
            margin-right: -10px;
            cursor: pointer;
            color: #9da1af;
            -webkit-transition: color 0.15s linear;
            transition: color 0.15s linear;
        }

        .add-control .refresh:hover {
            color: #666;
        }

        .form-control,
        .form-control:focus,
        .form-control:active,
        .form-control:active:focus {
            border: none;
            padding: 10px 15px;
            outline: none;
        }

        .form-control {
            -webkit-box-shadow: none;
            box-shadow: none;
            -webkit-transition: all 0.2s linear;
            transition: all 0.2s linear;
        }

        .form-control:focus {
            -webkit-box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
        }

        .separator {
            margin: 15px auto;
            width: 50%;
            height: 1px;

        }

        .animated {
            -webkit-animation-duration: 0.45s;
            animation-duration: 0.45s;
            -webkit-animation-fill-mode: both;
            animation-fill-mode: both;
        }

        .animated.fast {
            -webkit-animation-duration: 0.25s;
            animation-duration: 0.25s;
        }

        .today {
            text-align: center;
            color: #fff;
        }


        .zero {

            top: 8px;
            right: 0;
            font-size: 14px;
            -webkit-transform: translateX(100%);
            transform: translateX(100%);
            margin-right: -10px;
            cursor: pointer;
            color: #9da1af;
            -webkit-transition: color 0.15s linear;
            transition: color 0.15s linear;
        }

        .group:after {
            content: "";
            display: table;
            clear: both;
        }

        .btn_wrapper {
            @extend .group;
            max-width: 250px;
            margin: 0 auto;
        }


        button {

            font-size: 16px;
            color: #ffffff;
            background: #fff0;
            padding: 10px 20px;
            transition: all 0.3s;
            outline: none;
            border-color: #FFF;
            border-radius: 35px;
            margin-left: 5px;
            margin-right: 5px;
        }


        button[disabled] {
            color: #8d959b !important;
            background: #fff !important;
        }

        .output {
            padding-bottom: 10px;
        }

        .output button {
            color: #4b96f0;
        }

        .output button:hover,
        .output button:focus {
            transform: scale(1.5);
            background: transparent;
        }


        #start {
            background: #6200ff;
            border: none;
            border-radius: 20px;
            padding-left: 35px;
            padding-right: 35px;
        }

        #start:hover {


            box-shadow: 0 0 25px 0 #452579;
            color: white;
        }

        #inc {
            border: none;
            font-size: 40px;
            border-radius: 20px;
            padding-left: 35px;
            padding-right: 35px;
        }

        #dec {
            border: none;
            font-size: 40px;
            border-radius: 20px;
            padding-left: 35px;
            padding-right: 35px;
        }

        #reset {
            color: #e96575;
        }

        #reset:hover,
        #reset:focus {
            background-color: #e96575;
            color: #fff;
            border-radius: 20px;
            padding-left: 35px;
            padding-right: 35px;
        }

        .pomodoro {
            text-align: center;
        }

        p {
            margin: 15px 0 10px;
            font-size: 46px;
            font-weight: 700;
            color: #FFF;

        }


        .fa-ban:before {
            content: "\f05e";
            color: #8c8c8c;
            font-size: 29px;
        }


        .logo {
            text-align: center;
            margin-top: 30px;
            margin-bottom: -50px;
        }


        .h4,
        h4 {
            font-size: 16px;
            color: #fff;
            text-align: center;
            margin-top: 40px;
        }

        a:focus,
        a:hover {
            color: #fbfbfb;
            text-decoration: none;
        }

        .fa-remove:before,
        .fa-close:before,
        .fa-times:before {
            content: "\f00d";
            color: #000;
        }



        @media (max-width: 768px) {
            .col-xs-offset-3 {
                margin-left: 10%;
            }
        }

        @media (max-width: 768px) {
            .col-xs-6 {
                width: 80%;
            }
        }

        @viewport {
            width: device-width;
            zoom: 1;
        }

        @media (min-width: 992px) {
            .container {
                width: 100%;
                max-width: 1150PX;
            }
        }

        @media (max-width: 680px) {
            svg {
                width: 70px;
                height: 70px;

            }
        }

        .todo-list input[type="checkbox"] {
            opacity: 0;
        }
    </style>
</head>


<body class="body">
<div class="container">
    <div class="today"></div>
    <div class="row">
        <div class="col-md-4 col-md-offset-4 col-xs-6 col-xs-offset-3">
            <div class="add-control">
                <div class="form-group has-feedback">
                    <input type="text" class="form-control" placeholder="✍️ 添加待办项..." />
                    <i class="fa fa-plus form-control-feedback add-btn" title="Add item"></i>
                </div>
            </div>
            <p class="err text-danger text-center hidden"><i class="fa fa-warning"></i>
                请输入待办项！
            </p>
            <p class="no-items text-muted text-center hidden"><i class="fa fa-ban"></i></p>
            <ul class="todo-list">
            </ul>
        </div>
    </div>
</div>
</section>
</main>
</div>
<script src="https://cdn.bootcss.com/jquery/2.1.3/jquery.min.js"></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js'></script>
</body>
<script>
    var state = [];

    function setDefaultState() {
        var id = generateID();
        var baseState = {};
        baseState[id] = {
            status: "new",
            id: id,
            title: "This site uses 🍪to keep track of your tasks"
        };
        syncState(baseState);
    }

    function generateID() {
        var randLetter = String.fromCharCode(65 + Math.floor(Math.random() * 26));
        return randLetter + Date.now();
    }

    function pushToState(title, status, id) {
        var baseState = getState();
        baseState[id] = { id: id, title: title, status: status };
        syncState(baseState);
    }

    function setToDone(id) {
        var baseState = getState();
        if (baseState[id].status === 'new') {
            baseState[id].status = 'done'
        } else {
            baseState[id].status = 'new';
        }
        syncState(baseState);
    }

    function deleteTodo(id) {
        console.log(id)
        var baseState = getState();
        delete baseState[id]
        syncState(baseState)
    }

    function resetState() {
        localStorage.setItem("state", null);
    }

    function syncState(state) {
        localStorage.setItem("state", JSON.stringify(state));
    }

    function getState() {
        return JSON.parse(localStorage.getItem("state"));
    }

    function addItem(text, status, id, noUpdate) {
        var id = id ? id : generateID();
        var c = status === "done" ? "danger" : "";
        var item =
            '<li data-id="' +
            id +
            '" class="animated flipInX ' +
            c +
            '"><div class="checkbox"><span class="close"><i class="fa fa-times"></i></span><label><span class="checkbox-mask"></span><input type="checkbox" />' +
            text +
            "</label></div></li>";

        var isError = $(".form-control").hasClass("hidden");

        if (text === "") {
            $(".err")
                .removeClass("hidden")
                .addClass("animated bounceIn");
        } else {
            $(".err").addClass("hidden");
            $(".todo-list").append(item);
        }

        $(".refresh").removeClass("hidden");

        $(".no-items").addClass("hidden");

        $(".form-control")
            .val("")
            .attr("placeholder", "✍️ 添加待办项...");
            setTimeout(function () {
                $(".todo-list li").removeClass("animated flipInX");
            }, 500);

        if (!noUpdate) {
            pushToState(text, "new", id);
        }
    }

    function refresh() {
        $(".todo-list li").each(function (i) {
            $(this)
                .delay(70 * i)
                .queue(function () {
                    $(this).addClass("animated bounceOutLeft");
                    $(this).dequeue();
                });
        });

        setTimeout(function () {
            $(".todo-list li").remove();
            $(".no-items").removeClass("hidden");
            $(".err").addClass("hidden");
        }, 800);
    }

    $(function () {
        var err = $(".err"),
            formControl = $(".form-control"),
            isError = formControl.hasClass("hidden");

        if (!isError) {
            formControl.blur(function () {
                err.addClass("hidden");
            });
        }

        $(".add-btn").on("click", function () {
            var itemVal = $(".form-control").val();
            addItem(itemVal);
            formControl.focus();
        });

        $(".refresh").on("click", refresh);

        $(".todo-list").on("click", 'input[type="checkbox"]', function () {
            var li = $(this)
                .parent()
                .parent()
                .parent();
            li.toggleClass("danger");
            li.toggleClass("animated flipInX");

            setToDone(li.data().id);

            setTimeout(function () {
                li.removeClass("animated flipInX");
            }, 500);
        });

        $(".todo-list").on("click", ".close", function () {
            var box = $(this)
                .parent()
                .parent();

            if ($(".todo-list li").length == 1) {
                box.removeClass("animated flipInX").addClass("animated                bounceOutLeft");
                setTimeout(function () {
                    box.remove();
                    $(".no-items").removeClass("hidden");
                    $(".refresh").addClass("hidden");
                }, 500);
            } else {
                box.removeClass("animated flipInX").addClass("animated bounceOutLeft");
                setTimeout(function () {
                    box.remove();
                }, 500);
            }

            deleteTodo(box.data().id)
        });

        $(".form-control").keypress(function (e) {
            if (e.which == 13) {
                var itemVal = $(".form-control").val();
                addItem(itemVal);
            }
        });
        $(".todo-list").sortable();
        $(".todo-list").disableSelection();
    });

    $(document).ready(function () {
        var state = getState();
        for (const key in state) {
            if (!state[key].title) {
                delete state[key]
            }
        }

        if (!state) {
            setDefaultState();
            state = getState();
        }

        Object.keys(state).forEach(function (todoKey) {
            var todo = state[todoKey];
            addItem(todo.title, todo.status, todo.id, true);
        });

        var mins, secs, update;

        init();
        function init() {
            (mins = 25), (secs = 59);
        }


        set();
        function set() {
            $(".mins").text(mins);
        }


        $("#start").on("click", start_timer);
        $("#reset").on("click", reset);
        $("#inc").on("click", inc);
        $("#dec").on("click", dec);

        function start_timer() {

            set();

            $(".dis").attr("disabled", true);

            $(".mins").text(--mins);
            $(".separator").text(":");
            update_timer();

            update = setInterval(update_timer, 1000);
        }

        function update_timer() {
            $(".secs").text(secs);
            --secs;
            if (mins == 0 && secs < 0) {
                reset();
            } else if (secs < 0 && mins > 0) {
                secs = 59;
                --mins;
                $(".mins").text(mins);
            }
        }


        function reset() {
            clearInterval(update);
            $(".secs").text("");
            $(".separator").text("");
            init();
            $(".mins").text(mins);
            $(".dis").attr("disabled", false);
        }


        function inc() {
            mins++;
            $(".mins").text(mins);
        }


        function dec() {
            if (mins > 1) {
                mins--;
                $(".mins").text(mins);
            } else {
                alert("This is the minimum limit.");
            }
        }
    });

</script>

</html>