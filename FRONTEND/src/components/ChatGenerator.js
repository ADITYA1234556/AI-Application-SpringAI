import React, {useState} from "react";

function ChatGenerator() {

    const [question, setQuestion] = useState('');
    const [answer, setAnswer] = useState('');

    const askAI = async () => {
        try {
            const response = await fetch(`http://localhost:8080/askaioptions?prompt=${question}`)
            const data = await response.text();
            /* after we get the answer update it to setAnswer */
            console.log("Generated text : ", data);
            setAnswer(data);

        } catch (error) {
            console.error("Error generating text : ", error);
        }

    };

  return (
    <div>
        <h1>Ask me any question, I am your AI 😀</h1>
        <input type="text" value={question} onChange={(e) => setQuestion(e.target.value)} 
        placeholder="Enter your question" />
        <button onClick={askAI}>Ask AI Anything</button>

        <div className="output">
            <p>{answer}</p>
        </div>

    </div>
);
}

export default ChatGenerator;