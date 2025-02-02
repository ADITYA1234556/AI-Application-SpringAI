import React, {useState} from "react";

function RecipeGenerator() {

    const [ingredients, setIngredients] = useState('');
    const [dietaryRestictions, setDietaryRestictions] = useState('');
    const [cusine, setCusine] = useState('');
    const [recipe, setRecipe] = useState('');

    const createRecipe = async () => {
        try {
            const response = await fetch(`http://localhost:8080/recipe?ingredients=${ingredients}&dietaryRestictions=${dietaryRestictions}&cusine=${cusine}`)
            const recipe = await response.text();
            /* after we get the recipe update it to setRecipe */
            console.log("Generated recipe : ", recipe);
            setRecipe(recipe);

        } catch (error) {
            console.error("Error generating recipe : ", error);
        }

    };


  return (
  <div>
    <h1>Just tell me the ingredients you have, I can create a recipe for you.🍔</h1>
    <input type="text" value={ingredients} onChange={(e) => setIngredients(e.target.value)}
    placeholder="Add Ingredients (comma seperated) ♥️." />
    <input type="text" value={cusine} onChange={(e) => setCusine(e.target.value)}
    placeholder="Tell me which type of cusine you prefer ♥️." />
    <input type="text" value={dietaryRestictions} onChange={(e) => setDietaryRestictions(e.target.value)}
    placeholder="Add any dietary restrictions for me to consider ♥️." />

    <button onClick={createRecipe}>Create Recipe</button>
    <div className="output">
        <pre className="recipe-text">{recipe}</pre>
        </div>
  </div>);
}

export default RecipeGenerator;