import React from 'react';
import { useNavigate } from 'react-router-dom';

const MainPage: React.FC = () => {
    const navigate = useNavigate();

    const handleLottoClick = () => {
        navigate('/lotto');
    };

    const handleMoripClick = () => {
        navigate('/morip');
    };

    return (
        <div className="main-page">
            <div className="main-container">
                <h1 className="main-title">메인 페이지</h1>
                <div className="button-container">
                    <button
                        className="main-button lotto-button"
                        onClick={handleLottoClick}
                    >
                        🎱 로또
                    </button>
                    <button
                        className="main-button morip-button"
                        onClick={handleMoripClick}
                    >
                        🎮 모립
                    </button>
                </div>
            </div>
        </div>
    );
};

export default MainPage;
