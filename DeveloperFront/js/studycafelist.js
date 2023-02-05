$(()=>{
    let url= backURL + 'studyroom/list'
    let origin = $('div.studycafeList').first()
    function showList(url){
        let $origin = $('div.studycafe').first()
        $('div.studycafe').not(':first-child').remove()
        $origin.show()

        $.ajax({
            url:backURL+'studyroom/search',
            method:'get',
            datatype : "json",
            success: function (jsonObj){
                if(jsonObj.status <1){
                    alert(jsonObj.msg)
                    return
                }
                let $parent=$('div.studycafeList')

                $(list).each((index,s)=>{
                    let imgPath=s.imgPath;
                    let name=s.name;
                    let addr=s.addr;
                    let price=s.price;
                    let person=s.person;
                    let favCnt=s.cnt
                    let copy=$origin.clone();


                    let $imgObj = $('<img>')
                    $imgObj.attr('src','../images/'+imgPath+'.jpg')
                    $copy.find('div.img').empty().append($imgObj)
                    $copy.find('div.name').html(name)
                    $copy.find('div.price').html(price + '원/시간')
                    $copy.find('div.person').html('최대 '+person+'인')
                    $copy.find('div.favCnt').html(favCnt)

                })
                $origin.hide()

            },
            error: function(xhr){
                // alert(xhr.status)
                let jsonObj = JSON.parse(xhr.reponseText)
                alert(jsonObj)
            }
        })


    }

})