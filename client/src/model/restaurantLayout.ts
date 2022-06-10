/**
 * A RestaurantLayout that defines where the tables and seats are in a restaurant
 */
class RestaurantLayout {

}

export default RestaurantLayout;

/**
 * Checks if an object is a {@link RestaurantLayout}
 * @param cuisine the object to check
 * @returns `true` if the given value is a {@link RestaurantLayout}, `false` otherwise
 */
export const isRestaurantLayout = (restaurantLayout: any): restaurantLayout is RestaurantLayout => {
    return (typeof restaurantLayout === "object");
};