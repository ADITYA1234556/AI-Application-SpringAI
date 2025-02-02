import React, {useState} from "react";

function ImageGenerator() {
    const [prompt, setPrompt] = useState('');
    const [imageUrls, setImageUrls] = useState([]);

    const generateImage = async () => {
        try {
            const response = await fetch(`http://localhost:8080/genimage?imagePrompt=${prompt}`)
            const urls = await response.json();
            /* after we get the urls update it to setImagesUrls */
            console.log("Generated Image URLs : ", urls);
            setImageUrls(urls);

        } catch (error) {
            console.error("Error generating image : ", error);
        }

    }


    return (
        <div className="tab-content">
            <h1>Type how you want me to Generate an Image 🖼️</h1>
            {/* any change in input box will be sent to promt  */}
            <input type="text" value={prompt} onChange={(e) => setPrompt(e.target.value)} 
            placeholder="Enter text for what kind of image you want" /> 
            <button onClick={generateImage}>Generate Image </button>
            {/* when button is clicked const function generateImage will be called */}

            <div className="image-grid">
                {imageUrls.map((url, index) => (
                    <img key={index} src={url} alt={`Generated ${index}`} />
                ))}
                {[...Array(2)].map((_, index) => (
                // {[...Array(4 - imageUrls.length)].map((_, index) => ( #dynanic boxes based on image length
                    <div key={index + imageUrls.length} className="empty-image-slot"></div>
                ))}
            </div>

        </div>
    
);
}

export default ImageGenerator;