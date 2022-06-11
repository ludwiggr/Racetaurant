/**
 * The possible cuisines
 */
enum Cuisine {
    BALKAN = "balkan", ASIAN = "asian", ITALIAN = "italian", GERMAN = "german", INDIAN = "indian", TURKISH = "turkish", GREEK = "greek", AMERICAN = "american"
}

export default Cuisine;

/**
 * Checks if an object is a {@link Cuisine}
 * @param cuisine the object to check
 * @returns `true` if the given value is a {@link Cuisine}, `false` otherwise
 */
export const isCuisine = (cuisine: any): cuisine is Cuisine => {
    return (typeof cuisine === "string") && //
        Object.values(Cuisine).includes(cuisine as Cuisine);
};
