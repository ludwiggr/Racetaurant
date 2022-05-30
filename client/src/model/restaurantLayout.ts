class RestaurantLayout {

}

export default RestaurantLayout;

export const isRestaurantLayout = (restaurantLayout: any): restaurantLayout is RestaurantLayout => {
    return (typeof restaurantLayout === "object");
};