const adCards = document.querySelectorAll(".ad-card");
adCards.forEach(ad=>{
    const editButton = ad.querySelector(".edit");
    const deleteButton = ad.querySelector(".delete");
    const adId = ad.getAttribute("data-ad-id")
    editButton.addEventListener("click", ()=>{
        alert(`now editing ad ${adId}`)
    })
})