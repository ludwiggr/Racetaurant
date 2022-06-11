/**
 * A price category.
 * 0: inexpensive
 * 1: normal
 * 2: expensive
 */
type PriceCategory = 0 | 1 | 2;

export default PriceCategory;

/**
 * Checks if an object is a {@link PriceCategory}
 * @param priceCategory the object to check
 * @returns `true` if the given value is a {@link PriceCategory}, `false` otherwise
 */
export const isPriceCategory = (priceCategory: any): priceCategory is PriceCategory => {
    return (typeof priceCategory === "number") && //
        ([0, 1, 2].includes(priceCategory));
}