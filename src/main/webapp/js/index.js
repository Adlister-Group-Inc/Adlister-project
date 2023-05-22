document.addEventListener("DOMContentLoaded", function() {
    const sellerButton = document.getElementById("seller-button");
    console.log(sellerButton);
    const buyerButton = document.getElementById("buyer-button");
    console.log(buyerButton);
    const imgWrap1 = document.querySelector(".image-wrapper1");
    const imgWrap = document.querySelector(".image-wrapper");

    sellerButton.addEventListener("click", () => {
        console.log("seller button clicked");
        // Hide the buyer card and show the seller card
        imgWrap.style.display = "none";
        imgWrap1.style.display = "block";
    });

    buyerButton.addEventListener("click", () => {
        console.log("buyer button clicked");
        // Hide the seller card and show the buyer card
        imgWrap1.style.display = "none";
        imgWrap.style.display = "block";
    });
});