import React, { Component } from 'react'
import { Theme, useTheme } from '@mui/material/styles';
import Box from '@mui/material/Box';
import OutlinedInput from '@mui/material/OutlinedInput';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select, { SelectChangeEvent } from '@mui/material/Select';
import Chip from '@mui/material/Chip';
import { FilterProps } from './filter';
import Cuisine from '../model/cuisine';
import SelectInput from '@mui/material/Select/SelectInput';


function getStyles(name: string, personName: readonly string[], theme: Theme) {
    return {
        fontWeight:
            personName.indexOf(name) === -1
                ? theme.typography.fontWeightRegular
                : theme.typography.fontWeightMedium,
    };
}

const FilterCuisine: React.FC<FilterProps> = ({ filter, setFilter }) => {
    const theme = useTheme();

    const handleCuisine = (
        event: SelectChangeEvent<typeof filter["cuisines"]>
    ) => {
        setFilter({ ...filter, cuisines: event.target.value as Cuisine[] });
    };

    //Build cuisineFilter
    const renderFilterCuisine = (): JSX.Element => {
        return <FormControl sx={{ m: 1, width: 300 }}>
            <InputLabel id="multiple-cuisines-label">Cuisine</InputLabel>
            <Select
                labelId="multiple-cuisines-label"
                id="multiple-cuisines"
                multiple
                value={filter["cuisines"]}
                onChange={handleCuisine}
                input={<OutlinedInput id="multiple-cuisines" label="cuisine" />}
                renderValue={(selected) => (
                    <Box sx={{ display: 'flex', flexWrap: 'wrap', gap: 0.5 }}>
                        {selected.map((value) => (
                            <Chip key={value} label={value} />
                        ))}
                    </Box>
                )}
            >
                {(Object.keys(Cuisine) as Array<keyof typeof Cuisine>).map((name) => (
                    <MenuItem
                        key={name}
                        value={name}
                        style={getStyles(name, filter["cuisines"], theme)}
                    >
                        {name}
                    </MenuItem>
                ))}
            </Select>
        </FormControl >
    }

    return (
        renderFilterCuisine()
    );
}

export default FilterCuisine
