import { Button, Paper } from '@mui/material';
import React from 'react';
import RestaurantMap from '../components/restaurantMap';
import RestaurantInfo from '../components/restaurantInfo';
import RestaurantDetails from '../components/restaurantDetails';
import styles from '../styles/restaurantMapView.module.css';
import { FilterOptions, getRestaurants } from '../model/api';
import Restaurant from '../model/restaurant';
import Filter from '../components/filter';

export class RestaurantMapView extends React.Component<{}, {
    restaurants: Array<Restaurant>,
    restaurantHighlight: Restaurant | null,
    mapPaddingLeft: number,
    showFilter: boolean,
    filter: FilterOptions,
    detailsRestaurant?: Restaurant,
}> {
    constructor(props: any) {
        super(props);

        this.state = {
            restaurants: [],
            restaurantHighlight: null,
            mapPaddingLeft: 0,
            showFilter: false,
            filter: {},
        };

        this.updateSidebarWidth = this.updateSidebarWidth.bind(this);
        this.updateRestaurants = this.updateRestaurants.bind(this);
    }

    componentDidMount() {
        this.updateRestaurants();
    }

    /**
     * Updates the width of the sidebar in the state
     * @param sidebar the sidebar element
     */
    updateSidebarWidth(sidebar: HTMLDivElement) {
        if (!sidebar)
            return;
        const right = sidebar.getBoundingClientRect().right;
        if (this.state.mapPaddingLeft !== right)
            this.setState({ mapPaddingLeft: right });
    }

    /**
     * Re-loads all restaurants according to the current filters
     */
    updateRestaurants() {
        getRestaurants(this.state.filter).then(restaurants => this.setState({ restaurants: restaurants }));
    }

    render() {
        return (
            <div style={{ height: '100%' }}>
                <RestaurantMap
                    restaurants={this.state.restaurants}
                    padding={{ left: this.state.mapPaddingLeft }}
                    onHover={(restaurant, entered) => this.setState({ restaurantHighlight: entered ? restaurant : null })}
                />
                <Paper elevation={10} ref={this.updateSidebarWidth} className={styles.sidebar}>
                    <Button fullWidth variant="contained" color="secondary" onClick={() => this.setState({ showFilter: true })}>Filter</Button>
                    {this.state.restaurants.map(restaurant =>
                        <Paper key={restaurant.id} elevation={15} className={styles['restaurant-info-container']}>
                            <RestaurantInfo restaurant={restaurant} onClick={() => this.setState({ detailsRestaurant: restaurant })} />
                        </Paper>
                    )}
                </Paper>
                {this.state.showFilter &&
                    <div onClick={() => { this.setState({ showFilter: false }); this.updateRestaurants(); }} className={styles['popup-backdrop']}>
                        <Paper onClick={e => e.stopPropagation()} elevation={15} className={styles['popup-container']}>
                            <Filter filter={this.state.filter} setFilter={(filter) => this.setState({ filter: filter })} />
                        </Paper>
                    </div>
                }
                {this.state.detailsRestaurant &&
                    <div onClick={() => this.setState({ detailsRestaurant: undefined })} className={styles['popup-backdrop']}>
                        <Paper onClick={e => e.stopPropagation()} elevation={15} className={styles['popup-container']}>
                            <RestaurantDetails restaurant={this.state.detailsRestaurant} onClose={() => this.setState({ detailsRestaurant: undefined })} />
                        </Paper>
                    </div>
                }
            </div>
        );
    }
}

export default RestaurantMapView;