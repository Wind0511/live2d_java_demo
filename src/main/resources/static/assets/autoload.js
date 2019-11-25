window.onload=function () {
    live2d_settings['modelId'] = 1;                  // 默认模型 ID
    live2d_settings['modelTexturesId'] = 1;         // 默认衣服 ID
    live2d_settings['waifuSize'] = '280x380';        // 看板娘大小
    live2d_settings['waifuFontSize'] = '20px';       // 提示框字体
    live2d_settings['waifuToolTop'] = '-60px';       // 工具栏顶部边距
    live2d_settings['waifuDraggable'] = 'unlimited';    // 拖拽样式
    live2d_settings['waifuDraggableRevert'] = true;
    live2d_settings['modelAPI'] = 'http://localhost:8080/';   // 后台接口，这里是本机测试的时候用的，引用的时候请务必修改
    live2d_settings['homePageUrl'] = 'http://localhost:8080/index';       // 主页地址，可选 'auto'(自动), '{URL 网址}'，这个是测试的时候用的，引用请务必修改
//更多设置请参考waifu-tips.js可以在这里设置也可以直接在waifu-tips.js中修改，都能用
    initModel({
        "waifu": {
            "console_open_msg": ["哈哈，你打开了控制台，是想要看看我的秘密吗？"],
            "copy_message": ["你都复制了些什么呀？"],
            "screenshot_message": ["照好了嘛，是不是很可爱呢？"],
            "hidden_message": ["我们还能再见面的吧…(ToT)/~~~"],
            "load_rand_textures": ["我还没有其他衣服呢", "我的新衣服好看嘛"],
            "hour_tips": {
                "t5-7": ["早上好！一日之计在于晨，美好的一天就要开始了"],
                "t7-11": ["上午好！工作顺利嘛，不要久坐，多起来走动走动哦！"],
                "t11-14": ["中午了，工作了一个上午，现在是午餐时间！"],
                "t14-17": ["午后很容易犯困呢，今天的运动目标完成了吗？"],
                "t17-19": ["傍晚了！窗外夕阳的景色很美丽呢，最美不过夕阳红~"],
                "t19-21": ["晚上好，今天过得怎么样？"],
                "t21-23": ["已经这么晚了呀，早点休息吧，晚安~"],
                "t23-5": ["你是夜猫子呀？这么晚还不睡觉，明天起的来嘛"],
                "default": ["嗨~ 快来逗我玩吧！"]
            },
            "referrer_message": {
                "localhost": ["欢迎回家~<span style=\"color:#0099cc;\">『", "』</span>", " - "],
                "baidu": ["Hello! 来自 百度搜索 的朋友<br>你是搜索 <span style=\"color:#0099cc;\">", "</span> 找到的我吗？"],
                "google": ["Hello! 来自 谷歌搜索 的朋友<br>欢迎阅读<span style=\"color:#0099cc;\">『", "』</span>", " - "],
                "default": ["Hello! 来自 <span style=\"color:#0099cc;\">", "</span> 的朋友"],
                "none": ["欢迎浏览<span style=\"color:#0099cc;\">『", "』</span>", " - "]
            },
            "referrer_hostname": {
                // "example.com": ["示例网站"]自己加奥
            },
            "model_message": {
                "1": ["来自 这间教室被不回家社占领了 的 樱江樱桃 嘎呜~"],
                "2": ["来自 这间教室被不回家社占领了 的 柊木耶宵 ~"]
            },
            "hitokoto_api_message": {
                //这里就留下了一个接口
                "hitokoto.cn": ["这句一言来自 <span style=\"color:#0099cc;\">『{source}』</span>，是 <span style=\"color:#0099cc;\">{creator}</span> 投稿的。"]
            }
        },
        "mouseover": [
            { "selector": ".container a[href^='/']", "text": ["要看看 <span style=\"color:#0099cc;\">{text}</span> 么？"] },
            { "selector": ".fui-home", "text": ["要回到梦开始的地方吗(>▽<)"] },
            { "selector": ".fui-chat", "text": ["一言一语~"] },
            { "selector": ".fui-eye", "text": ["嗯··· 要切换 看板娘 吗？￣△￣"] },
            { "selector": ".fui-user", "text": ["我换衣服的时候不要乱看哦(*/ω＼*)"] },
            { "selector": ".fui-photo", "text": ["要记录下我的可爱吗？（´v｀）"] },
            { "selector": ".fui-info-circle", "text": ["这里有关于我的信息呢"] },
            { "selector": ".fui-cross", "text": ["你不喜欢我了吗...o(TヘTo)"] },
            { "selector": ".waifu #live2d", "text": ["干嘛呢你，快把手拿开", "鼠…鼠标放错地方了！"] },
            { "selector": "#text", "text": ["要试一下吗","嘤嘤嘤嘤嘤嘤嘤(>▽<)"] }
        ],
        "click": [
            {
                "selector": ".waifu #live2d",
                "text": [
                    "是…是不小心碰到了吧",
                    "萝莉控是什么呀",
                    "你看到我的小熊了吗",
                    "再摸的话我可要报警了！⌇●﹏●⌇",
                    "110吗，这里有个变态一直在摸我(ó﹏ò｡)"
                ]
            }
        ],
        "seasons": [
            { "date": "01/01", "text": ["<span style=\"color:#0099cc;\">元旦</span>了呢，新的一年又开始了，今年是{year}年~"] },
            { "date": "02/14", "text": ["又是一年<span style=\"color:#0099cc;\">情人节</span>，{year}年找到对象了嘛~"] },
            { "date": "03/08", "text": ["今天是<span style=\"color:#0099cc;\">妇女节</span>！"] },
            { "date": "03/12", "text": ["今天是<span style=\"color:#0099cc;\">植树节</span>，要保护环境呀"] },
            { "date": "04/01", "text": ["悄悄告诉你一个秘密~<span style=\"background-color:#34495e;\">今天是愚人节，不要被骗了哦~</span>"] },
            { "date": "05/01", "text": ["今天是<span style=\"color:#0099cc;\">五一劳动节</span>，计划好假期去哪里了吗~"] },
            { "date": "06/01", "text": ["<span style=\"color:#0099cc;\">儿童节</span>了呢，快活的时光总是短暂，要是永远长不大该多好啊…"] },
            { "date": "09/03", "text": ["<span style=\"color:#0099cc;\">中国人民抗日战争胜利纪念日</span>，铭记历史、缅怀先烈、珍爱和平、开创未来。"] },
            { "date": "09/10", "text": ["<span style=\"color:#0099cc;\">教师节</span>，在学校要给老师问声好呀~"] },
            { "date": "10/01", "text": ["今天是<span style=\"color:#0099cc;\">国庆节</span>哦~ 规划好你的假期了吗？"] },
            { "date": "11/05-11/12", "text": ["今年的<span style=\"color:#0099cc;\">双十一</span>是和谁一起过的呢~"] },
            { "date": "12/20-12/31", "text": ["这几天是<span style=\"color:#0099cc;\">圣诞节</span>，主人肯定又去steam剁手买买买了~"] }
        ]
    });
}