$(() => { 

    function showList(url, page){
        let $origin = $('div.lesson').first();
        $('div.lesson').not(':first-child').remove(); 
        $origin.show(); 

        $.ajax({
            url : url,
            method: 'get',
            data: 'currentPage=' + page,
            success: function(jsonObj){ 
                let list = jsonObj.list;
                let totalPage = jsonObj.totalPage;
                let currentPage = jsonObj.currentPage;
                let startPage = jsonObj.startPage;
                let endPage = jsonObj.endPage;

                //원본
                let $origin = $('div.lesson').first();  //$가 붙어있으면 jQuery용 변수
                let $parent = $('div.lessonList');
                $(list).each((index, p) => {
                    let prodNo = p.prodNo;
                    let prodName = p.prodName;
                    let prodPrice = p.prodPrice;

                    let $copy = $origin.clone();
                    let $imgObj = $('<img>') //img태그 객체를 만드는 것
                    $imgObj.attr('src', '../images/' + prodNo + '.jpg');
                    $copy.find('div.img').empty().append($imgObj);
                    $copy.find('div.prodNo').html(prodNo); // .html() : div태그의 내부의 영역
                    $copy.find('div.prodName').html(prodName);
                    $copy.find('div.prodPrice').html(prodPrice + '원') ;

                    $parent.append($copy); //부모의 마지막 요소로 추가
                });
                $origin.hide(); //원본 껍데기 숨기기

                let $pageGroup = $('div.pagegroup');
                let pageGroupStr = "";

                //무조건 startPage의 이전 페이지가 있다
                if(startPage > 1){ 
                    pageGroupStr += '<span class="' + (startPage-1) + '">[PREV}</span>'; //<span>은 대표적인 인라인태그
                }

                //총합을 넘어서지 못하게 totalPage값을 대입 시키기
                if(endPage > totalPage){ 
                    endPage = totalPage;
                }

                //for문 돌려서 페이지 넘버링
                for(let i=startPage; i<=endPage; i++){
                    if(i == currentPage){ //현재페이지 구분시키기
                        pageGroupStr += '<span class="current' + i + '">[' + i + ']</span>'; 
                    } else {
                        pageGroupStr += ' <span class="' + i + '">[' + i + ']</span>';
                    }
                }
                //무조건 endPage의 다음 페이지가 있다. 
                if(endPage < totalPage){
                    pageGroupStr += '<span class="' + (endPage+1) + '">[NEXT]</span>';
                }
                $pageGroup.html(pageGroupStr);
            },
            error:function(xhr){
                let jsonObj =  JSON.parse(xhr.responseText);
                alert(jsonObj.msg);
            }
        });
    };
    let url = backURL + '/product/list';

    // == 상품목록 요청 START
    //무조건 첫페이지부터 출력시켜주기
    showList(url, 1); 
    // == 상품목록 요청 END

    // == 페이지번호 클릭 START
    $('div.pagegroup').on('click', 'span:not(.current)', (e) => { //span 태그가 current가 아닌 애들을 클릭했을 때
        let page = $(e.target).attr('class');
        showList(url, page);
    });
    // == 페이지번호 클릭 END

    // == 상품 상세정보 START
    $('div.productlist').on('click', 'div.product', (e) => {
        let prodNo = $(e.target).parents('div.product').find('div.prodNo').html();
        location.href = './productinfo.html?prodNo=' + prodNo;
    });
    // == 상품 상세정보 END
});
