const playBtn = document.getElementById('playBtn');
const audio = document.getElementById('hbdAudio');

playBtn.addEventListener('click', () => {
  if (audio.paused) {
    audio.play();
    playBtn.textContent = '⏸️ Stop Song';
    playBtn.style.background = '#9e2a2b'; // Merah Delima pas lagi diputar
    playBtn.style.color = '#ffffff';
  } else {
    audio.pause();
    playBtn.textContent = '▶️ Play Song';
    playBtn.style.background = '#ffb703'; // Gold Egg
    playBtn.style.color = '#0b132b';
  }
});