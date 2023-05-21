document.addEventListener("DOMContentLoaded", function() {
    const adCards = document.querySelectorAll(".ad-card");

    adCards.forEach(ad => {
        const editButton = ad.querySelector(".edit");
        const deleteButton = ad.querySelector(".delete");
        const adId = ad.getAttribute("data-ad-id");
        const form = ad.nextElementSibling;  // The associated form
        const deleteForm = ad.nextElementSibling.nextElementSibling;

        editButton.addEventListener("click", () => {
            // Hide the ad card and show the form
            ad.style.display = "none";
            form.style.display = "block";

        });
        deleteButton.addEventListener("click", () => {
            // hide the ad card and show the form that already has the class delete-form
            ad.style.display = "none";
            deleteForm.style.display = "block";
        });

    });
});