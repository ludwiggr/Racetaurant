type PriceCategory = 0 | 1 | 2;

export default PriceCategory;

export const isPriceCategory = (priceCategory: any): priceCategory is PriceCategory => {
    return (typeof priceCategory === "number") && //
        ([0, 1, 2].includes(priceCategory));
}