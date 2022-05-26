import React, { useContext, useState } from "react";
import { CssBaseline, useMediaQuery } from "@mui/material";
import { createTheme, ThemeOptions, ThemeProvider } from "@mui/material/styles";

type ThemeMode = 'light' | 'dark';
type SelectableThemeMode = ThemeMode | 'preference';
type ThemeModeContextType = { selected: SelectableThemeMode, current: ThemeMode, setMode: (mode: SelectableThemeMode) => void };

const ThemeModeContext = React.createContext<ThemeModeContextType>({
    selected: 'preference',
    current: 'light',
    setMode: () => console.warn('Tried to set mode while not in Theme context.')
});

/**
 * A hook for getting and modifying the currently active theme mode
 * @returns the currently active theme mode
 */
export const useThemeMode = () => {
    return useContext(ThemeModeContext);
};

/**
 * A consumer component for getting and modifying the currently active theme mdoe
 */
export const ThemeModeConsumer = ThemeModeContext.Consumer;

const Theme = (props: { children: React.ReactNode, theme: ThemeOptions }) => {
    const [selectedMode, setSelectedMode] = useState<SelectableThemeMode>('preference');
    const preferredMode: ThemeMode = useMediaQuery('(prefers-color-scheme: dark)') ? 'dark' : 'light';
    const mode: ThemeMode = selectedMode === 'preference' ? preferredMode : selectedMode;

    const theme = createTheme({
        ...props.theme,
        palette: {
            ...props.theme.palette,
            mode: mode,
        }
    });

    return (
        <ThemeProvider theme={theme}>
            <CssBaseline />
            <ThemeModeContext.Provider value={{
                selected: selectedMode,
                current: mode,
                setMode: setSelectedMode
            }}>
                {props.children}
            </ThemeModeContext.Provider>
        </ThemeProvider>
    );
}

export default Theme;