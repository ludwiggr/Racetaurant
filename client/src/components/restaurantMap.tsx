import { CenterFocusStrong } from '@mui/icons-material';
import { Fab } from '@mui/material';
import leaflet, { ControlPosition, Map } from 'leaflet';
import 'leaflet/dist/leaflet.css';
import React from 'react';
import { MapContainer, Marker, TileLayer, ZoomControl } from 'react-leaflet';
import Restaurant from '../model/restaurant';
import styles from '../styles/restaurantMap.module.css';
import { ReactControl } from '../utils/leafletCustomControl';
import '../utils/leafletDefaultIconFixer';
import { shallowEqual } from 'fast-equals';

/**
 * A RestaurantMap displays the locations of the passed restaurants on a map
 */
export class RestaurantMap extends React.Component<{
    restaurants: Array<Restaurant>,
    onClick?: (restaurant: Restaurant) => void,
    onHover?: (restaurant: Restaurant, entered: boolean) => void,
    padding?: { top?: number, right?: number, bottom?: number, left?: number },
    zoomPosition?: ControlPosition | 'none',
    resetPosition?: ControlPosition | 'none',
}, {
    mapMoved: boolean,
}> {

    private bounds: leaflet.LatLngBounds;
    private map: Map | null = null;

    constructor(props: any) {
        super(props);

        this.state = {
            mapMoved: false,
        };

        // calculate bounds to fit all restaurants
        const locations = this.props.restaurants.map(r => r.location);
        this.bounds = leaflet.latLngBounds([
            Math.min(...locations.map(l => l.latitude)),
            Math.min(...locations.map(l => l.longitude))
        ], [
            Math.max(...locations.map(l => l.latitude)),
            Math.max(...locations.map(l => l.longitude))
        ]);

        this.resetPosition = this.resetPosition.bind(this);
        this.mapMoved = this.mapMoved.bind(this);
    }

    componentDidMount() {
        window.addEventListener('resize', this.mapMoved);
    }

    componentWillUnmount() {
        window.removeEventListener('resize', this.mapMoved);
    }

    /**
     * Indicated that the position of the map has moved (and a reset button should be shown)
     */
    mapMoved() {
        this.setState({ mapMoved: true });
    }

    componentDidUpdate(prevProps: any) {
        if (!shallowEqual(this.props.padding, prevProps.padding))
            this.resetPosition();
    }

    /**
     * Resets the position of the map to fit all restaurants while respecting the padding
     */
    resetPosition() {
        this.map?.fitBounds(this.bounds, {
            paddingTopLeft: new leaflet.Point(this.props.padding?.left || 0, this.props.padding?.top || 0),
            paddingBottomRight: new leaflet.Point(this.props.padding?.right || 0, this.props.padding?.bottom || 0),
            duration: 0.75,
            animate: true,
            easeLinearity: 0,
        });
        this.setState({ mapMoved: false });
    }

    render() {
        return (
            <MapContainer
                ref={map => {
                    this.map = map;
                    map?.on('dragend', this.mapMoved);
                    map?.on('zoomend', this.mapMoved);
                }}
                zoomControl={false}
                boundsOptions={{
                    paddingTopLeft: new leaflet.Point(this.props.padding?.left || 0, this.props.padding?.top || 0),
                    paddingBottomRight: new leaflet.Point(this.props.padding?.right || 0, this.props.padding?.bottom || 0)
                }}
                bounds={this.bounds}
                attributionControl={true}
                scrollWheelZoom={true}
                style={{ width: '100%', height: '100%', zIndex: 0 }}
            >
                <TileLayer
                    attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors | Imagery by <a href="https://openstreetmap.de/">openstreetmap.de</a>'
                    url="https://{s}.tile.openstreetmap.de/{z}/{x}/{y}.png"
                />
                {this.props.zoomPosition !== 'none' && <ZoomControl position={this.props.zoomPosition || 'topright'} />}
                {this.props.restaurants.map(restaurant => (
                    <Marker
                        key={restaurant.id}
                        position={[restaurant.location.latitude, restaurant.location.longitude]}
                        title={restaurant.location.address}
                        eventHandlers={{
                            click: () => this.props.onClick?.(restaurant),
                            mouseover: () => this.props.onHover?.(restaurant, true),
                            mouseout: () => this.props.onHover?.(restaurant, false),
                        }}
                    />
                ))}
                {this.props.resetPosition !== 'none' &&
                    <ReactControl position={this.props.resetPosition || 'bottomright'}>
                        <Fab
                            color="default"
                            onClick={this.resetPosition}
                            className={styles['reset-view-button'] + ' ' + (this.state.mapMoved ? styles.shown : styles.hidden)}
                        >
                            <CenterFocusStrong />
                        </Fab>
                    </ReactControl>
                }
            </MapContainer>
        );
    }
}

export default RestaurantMap;