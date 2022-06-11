import axios from "axios";
import Cuisine from "./cuisine";
import PriceCategory from "./priceCategory";
import Restaurant, { isRestaurant, isRestaurantArray } from "./restaurant";
import Review, { isReviewArray } from "./review";
import qs from 'qs';

axios.defaults.paramsSerializer = params => {
    return qs.stringify(params, { arrayFormat: 'repeat', /* param = [value1, value2] -> param=value1&param=value2 */ });
};

export type FilterOptions = {
    price?: PriceCategory,
    latitude?: number,
    longitude?: number,
    radius?: number,
    cuisines?: Array<Cuisine>,
    rating_min?: number,
    rating_max?: number,
    time_start?: Date,
    time_stop?: Date,
    persons?: number,
}

export type APIError = {
    message: string,
    supplemental?: any
}

export const isAPIError = (apiError: any): apiError is APIError => {
    return (typeof apiError === "object") && (typeof apiError.message === "string");
}

const axios_catch = (reject: (error: any) => void) => (error: any) => {
    reject({
        message: "API request failed",
        supplemental: error
    });
};

const getRestaurants = (filter?: FilterOptions, start?: number, limit?: number, order?: "id" | "name" | "rating", asc?: boolean): Promise<Array<Restaurant>> => {
    return new Promise((resolve, reject) => {
        axios.get("/api/restaurants", {
            params: { ...filter, start: start, limit: limit, order: order, asc: asc }
        }).then(result => {
            if (isRestaurantArray(result.data))
                resolve(result.data);
            reject({
                message: "API did not return an array of restaurants",
                supplemental: result.data
            });
        }).catch(axios_catch(reject));
    });
}

const getRestaurantById = (id: string): Promise<Restaurant> => {
    return new Promise((resolve, reject) => {
        axios.get(`/api/restaurants/${encodeURIComponent(id)}`).then(result => {
            if (isRestaurant(result.data))
                resolve(result.data);
            reject({
                message: "API did not return a restaurant",
                supplemental: result.data
            });
        }).catch(axios_catch(reject));
    });
}

const getReviews = (id: string): Promise<Array<Review>> => {
    return new Promise((resolve, reject) => {
        axios.get(`/api/restaurants/${encodeURIComponent(id)}/reviews`).then(result => {
            if (isReviewArray(result.data))
                resolve(result.data);
            reject({
                message: "API did not return an array of reviews",
                supplemental: result.data
            });
        }).catch(axios_catch(reject));
    })
}

export { getRestaurants, getRestaurantById, getReviews };
