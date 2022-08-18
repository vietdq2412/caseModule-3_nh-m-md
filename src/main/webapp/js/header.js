function setHeader(user){
    let headerDiv = document.getElementById("header");
    let linkAdmin = "";
    if (user){
        linkAdmin = `<li><a href="/books">Admin</a></li>`
    }
    let headerContent = `<div class="col-xl-3 col-lg-2">
                <div class="header__logo">
                    <a href="./index.html"><img src="img/logo.png" alt=""></a>
                </div>
            </div>
            <div class="col-xl-6 col-lg-7">
                <nav class="header__menu">
                    <ul>
                        <li><a href="./index.html">Home</a></li>
                        <li class="active"><a href="/books?action=shop">Shop</a></li>
                        <li><a href="#">Pages</a>
                            <ul class="dropdown">
                                <li><a href="/shop-carts">Shop Cart</a></li>
                                <li><a href="shop-carts?action=checkout">Checkout</a></li>
                            </ul>
                        </li>
                        <li><a href="./contact.html">Contact</a></li>
                        `+linkAdmin+`
                    </ul>
                </nav>
            </div>
            <div class="col-lg-3">
                <div class="header__right">
                    <div class="header__right__auth">
                        <a href="#">Login</a>
                        <a href="#">Register</a>
                    </div>
                    <ul class="header__right__widget">
                        <li><span class="icon_search search-switch"></span></li>
                        <li><a href="#"><span class="icon_heart_alt"></span>
                            <div class="tip">2</div>
                        </a></li>
                        <li><a href="/shop-carts"><span class="icon_bag_alt"></span>
                            <div class="tip">2</div>
                        </a></li>
                    </ul>
                </div>
            </div>`

    headerDiv.innerHTML = headerContent;
}