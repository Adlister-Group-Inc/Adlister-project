document.addEventListener("DOMContentLoaded", function() {
    const sellerButton = document.getElementById("seller-button");
    const buyerButton = document.getElementById("buyer-button");
    const imgWrap1 = document.querySelector(".image-wrapper1");
    const imgWrap = document.querySelector(".image-wrapper");

    sellerButton.addEventListener("click", () => {
        // Hide the buyer card and show the seller card
        imgWrap.style.display = "none";
        imgWrap1.style.display = "block";
    });

    buyerButton.addEventListener("click", () => {
        // Hide the seller card and show the buyer card
        imgWrap1.style.display = "none";
        imgWrap.style.display = "block";
    });
});