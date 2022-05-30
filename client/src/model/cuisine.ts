enum Cuisine {
    BALKAN = "balkan", ASIAN = "asian", ITALIAN = "italian", GERMAN = "german", INDIAN = "indian", TURKISH = "turkish", GREEK = "greek", AMERICAN = "american"
}

export default Cuisine;

export const isCuisine = (cuisine: any): cuisine is Cuisine => {
    return (typeof cuisine === "string") && //
        Object.values(Cuisine).includes(cuisine as Cuisine);
};