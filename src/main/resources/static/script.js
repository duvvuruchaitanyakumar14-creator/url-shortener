async function shortenUrl() {

    const longUrl =
        document.getElementById("longUrl").value;

    if (!longUrl.trim()) {
        alert("Please enter a URL");
        return;
    }

    try {

        const response = await fetch(
            "http://localhost:8080/shorten",
            {
                method: "POST",
                headers: {
                    "Content-Type":
                        "application/x-www-form-urlencoded"
                },
                body:
                    "longUrl=" +
                    encodeURIComponent(longUrl)
            }
        );

        if (!response.ok) {
            throw new Error(
                "Failed to shorten URL"
            );
        }

        const data =
            await response.json();

        const shortLink =
            "http://localhost:8080/" +
            data.shortUrl;

        document.getElementById(
            "shortUrl"
        ).innerHTML =
            `
            <a href="${shortLink}" target="_blank">
                ${shortLink}
            </a>
            `;

    } catch (error) {

        console.error(error);

        alert(
            "Something went wrong. Check backend."
        );
    }
}

function copyUrl() {

    const text =
        document.getElementById(
            "shortUrl"
        ).innerText;

    if (!text) {
        alert("No URL to copy");
        return;
    }

    navigator.clipboard
        .writeText(text)
        .then(() => {
            alert("Copied!");
        });
}